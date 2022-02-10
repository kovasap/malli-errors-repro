(ns app.core
  (:require
   [reagent.core :as r]
   [reagent.dom :as d]
   ["react-data-grid" :as DataGrid]))

(defn maps-to-datagrid
  [maps]
  [(r/adapt-react-class DataGrid)
   {:columns (map (fn [m] {:key m :name (name m)})
                  (keys (first maps)))
    :rows maps}])

(defn home-page []
  (fn []
    [:div [:h2 "My App"]
     [maps-to-datagrid [{:key "value"}]]]))


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
