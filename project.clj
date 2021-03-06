(defproject bach-rest-api "2.0.0"
  :description "Simple RESTful HTTP interface for the official Bach library"
  :url "http://github.com/slurmulon/bach-rest-api"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [bach "2.0.0-SNAPSHOT"]
                 [compojure "1.5.1"]
                 [ring/ring-json "0.4.0"]
                 [ring-json-response "0.2.0"]
                 [ring/ring-defaults "0.2.1"]
                 [org.clojure/tools.logging "0.5.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler bach-rest-api.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
