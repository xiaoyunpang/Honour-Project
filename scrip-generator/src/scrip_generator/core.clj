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
  (str "insert Award \"" table-name
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
