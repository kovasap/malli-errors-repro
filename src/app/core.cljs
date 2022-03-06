(ns app.core
  (:require
   [app.helper :as h]
   [reagent.dom :as d]
   [malli.dev.cljs :as dev]
   [malli.dev.pretty :as pretty]))


(defn home-page []
  (h/my-helper [1.2])
  (fn []
    [:div "test"]))


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))


(dev/start! {:report (pretty/reporter)})
