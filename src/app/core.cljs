(ns app.core
  (:require
   [reagent.dom :as d]
   [oz.core :as oz]))


(defn home-page []
  (fn []
    [:div [:h2 "My App"]
     [oz.core/vega-lite
      {:data {:values [{:x 1 :y 2}
                       {:x 2 :y 4}
                       {:x 3 :y 6}]}
       :mark "point"
       :encoding {:x {:field :x
                      :type "nominal"}
                  :y {:field :y
                      :type "quantitative"}}}]]))


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
