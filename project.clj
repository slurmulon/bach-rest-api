(defproject warble-rest-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://github.com/slurmulon/warble-rest-api"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [warble "0.1.0-SNAPSHOT"]
                 [compojure "1.5.1"]
                 [ring/ring-json "0.4.0"]
                 [ring-json-response "0.2.0"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler warble-rest-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
