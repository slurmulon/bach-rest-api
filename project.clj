(defproject warble-rest-api "0.1.0-SNAPSHOT"
  :description "Simple RESTful HTTP interface for the Warble library"
  :url "https://github.com/slurmulon/warble-rest-api"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler warble-rest-api.core/handler}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [warble "0.1.0-SNAPSHOT"]
                 [liberator "0.13"]
                 [compojure "1.3.4"]
                 [ring/ring-core "1.2.1"]])
