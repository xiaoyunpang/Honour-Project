(defproject scrip-generator "0.1.0-SNAPSHOT"
  :description "A generator to generate IQL script"
  :url "https://github.com/xiaoyunpang/Honour-Project"
  :license {:name "GNU Affero General Public License v3.0"
            :url "https://opensource.org/licenses/AGPL-3.0"}
  :dependencies [[cider/cider-nrepl "0.14.0"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/data.csv "0.1.3"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.10"]
                                  [midje "1.7.0"]]
                   :plugins [[lein-midje "3.1.1"]]}
             :uberjar {:aot :all}}
  :main scrip-generator.core
  ;;:target-path "target/%s"
  :uberjar-exclusions [#"(?i)^META-INF/[^/]*\.SF$"])
