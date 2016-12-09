(ns scrip-generator.core
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [clojure.string :as string])
  (:gen-class))

(def ^:private table-name "Award-System")

(declare parse-line)

(defn generate-script
  [source-file output-file]
  (with-open [inf (io/reader source-file)]
    (with-open [f (io/writer output-file)]
      (let [read-contents (->> inf
                               csv/read-csv
                               rest
                               (map parse-line)
                               )]
        (dorun (map (fn [data] (binding [*out* f] (println data))) read-contents))))))

(defn- polish-text
  [text]
  (if (nil? text)
    text
    (-> text
        (string/replace #";" ",")
        (string/replace #"\"" "'"))))

(defn- parse-line
  [{title 0
    c-year 1
    f-year 2
    name 3
    institution 4
    department 5
    province 6
    amount 7
    installment 8
    program 9
    committee 10
    subject 11
    application 12
    co-researchers 13
    partners 14
    summary 15}]
  (str "insert Award \"" (str table-name (java.util.UUID/randomUUID))
       "\"[@title: \"" (polish-text title) "\", "
       "@competitionYear: " c-year ", "
       "@fiscalYear: \"" f-year "\", "
       "@leadName: \"" name "\", "
       "@institution: \"" (polish-text institution) "\", "
       "@department: \"" (polish-text department) "\", "
       "@province: \"" province "\", "
       "@amount: " (string/replace amount #"[$,]" "") ", "
       "@installment: \"" (string/replace installment #"-" "\\\\-") "\", "
       "@program: \"" (polish-text program) "\", "
       "@committee: \"" (polish-text committee) "\", "
       "@subject: \"" (polish-text subject) "\", "
       "@areaOfApplication: \"" (polish-text application) "\", "
       "@coresearchers: \"" co-researchers "\", "
       "@partners: \"" partners "\", "
       "@summary: \"" (polish-text summary) "\"];"))

(defn -main
  [source-file output-file]
  (generate-script source-file output-file))


(defn temp
  []
  (with-open [inf (io/reader "/Users/xiaoyunpang/work/Honour-Project/database/result.csv")]
    (with-open [f (io/writer "/Users/xiaoyunpang/work/Honour-Project/database/insert-institution.iql")]
      (let [read-contents (->> inf
                               csv/read-csv
                               (map (fn [row] (map (fn [x] (string/replace x #"," "")) row)))
                               (map (fn [row]
                                      (str "insert Institution \"institution"
                                           (java.util.UUID/randomUUID) "\"[@names: \"" (first row) "\", "
                                           "@number: " (second row) ", "
                                           "@amount: " (nth row 2) "];")))
                               )]
        (dorun (map (fn [data] (binding [*out* f] (println data))) read-contents))
        ))))

(defn cyear
  []
  (with-open [inf (io/reader "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-award-database.iql")]
    (with-open [f (io/writer "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-cyear.iql")]
      (let [read-map (->> inf
                          line-seq
                          (map #(string/split % #"@competitionYear: |, @fiscalYear|, @leadName: |, @institution: |, @department: |, @province: |, @amount: "))
                          (map (fn [row]
                                 (vec (concat (subvec row 1 2) (subvec row 4 7)))))
                          (group-by first))
            read-keys (into [] (keys read-map))
            write-data (map (fn [akey]
                              (let [n (string/join "," (into [] (distinct (map #(nth % 2) (read-map akey)))))
                                    p (string/join "," (into [] (distinct (map last (read-map akey)))))
                                    i (string/join "," (into [] (distinct (map second (read-map akey)))))]
                                (str "insert Cyear \"" akey "\"[@competitionYear:" akey ",@leadName:{"
                                     n "},@province:{" p "},@institution:{" i "}];")))
                            read-keys)
            ]
        (dorun (map (fn [data] (binding [*out* f] (println data))) write-data))
        ))))

(defn lname
  []
  (with-open [inf (io/reader "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-award-database.iql")]
    (with-open [f (io/writer "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-lname.iql")]
      (let [read-map (->> inf
                          line-seq
                          (map #(string/split % #"@competitionYear: |, @fiscalYear|, @leadName: |, @institution: |, @department: |, @province: |, @amount: "))
                          (map (fn [row]
                                 (vec (concat (subvec row 1 2) (subvec row 4 7)))))
                          (group-by #(nth % 2)))
            read-keys (into [] (keys read-map))
            write-data (map (fn [akey]
                              (let [c (string/join "," (into [] (distinct (map first (read-map akey)))))
                                    p (string/join "," (into [] (distinct (map last (read-map akey)))))
                                    i (string/join "," (into [] (distinct (map second (read-map akey)))))]
                                (str "insert Leadname " (str "\""(java.util.UUID/randomUUID) "\"")
                                     "[@competitionYear:{" c "},@leadName:"
                                     akey ",@province:{" p "},@institution:{" i "}];")))
                            read-keys)
            ]
        (dorun (map (fn [data] (binding [*out* f] (println data))) write-data))
        ))))

(defn province
  []
  (with-open [inf (io/reader "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-award-database.iql")]
    (with-open [f (io/writer "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-province.iql")]
      (let [read-map (->> inf
                          line-seq
                          (map #(string/split % #"@competitionYear: |, @fiscalYear|, @leadName: |, @institution: |, @department: |, @province: |, @amount: "))
                          (map (fn [row]
                                 (vec (concat (subvec row 1 2) (subvec row 4 7)))))
                          (group-by last))
            read-keys (into [] (keys read-map))
            write-data (map (fn [akey]
                              (let [c (string/join "," (into [] (distinct (map first (read-map akey)))))
                                    n (string/join "," (into [] (distinct (map #(nth % 2) (read-map akey)))))
                                    i (string/join "," (into [] (distinct (map second (read-map akey)))))]
                                (str "insert Province " (-> akey (string/replace #" " "")
                                                            (string/replace #"'" ""))
                                     "[@competitionYear:{" c "},@leadName:{"
                                     n "},@province:" akey ",@institution:{" i "}];")))
                            read-keys)
            ]
        (dorun (map (fn [data] (binding [*out* f] (println data))) write-data))
        ))))

(defn institution
  []
  (with-open [inf (io/reader "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-award-database.iql")]
    (with-open [f (io/writer "/Users/xiaoyunpang/work/Honour-Project/renew-database/insert-institution.iql")]
      (let [read-map (->> inf
                          line-seq
                          (map #(string/split % #"@competitionYear: |, @fiscalYear|, @leadName: |, @institution: |, @department: |, @province: |, @amount: "))
                          (map (fn [row]
                                 (vec (concat (subvec row 1 2) (subvec row 4 7)))))
                          (group-by second))
            read-keys (into [] (keys read-map))
            write-data (map (fn [akey]
                              (let [c (string/join "," (into [] (distinct (map first (read-map akey)))))
                                    n (string/join "," (into [] (distinct (map #(nth % 2) (read-map akey)))))
                                    p (string/join "," (into [] (distinct (map last (read-map akey)))))]
                                (str "insert Institution " (str "\""(java.util.UUID/randomUUID) "\"")
                                     "[@competitionYear:{" c "},@leadName:{"
                                     n "},@province:{" p "},@institution:" akey "];")))
                            read-keys)
            ]
        (dorun (map (fn [data] (binding [*out* f] (println data))) write-data))
        ))))
