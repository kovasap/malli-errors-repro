(ns app.core
  (:require
   [app.helper :as h]
   [reagent.dom :as d]
   [malli.dev.cljs :as dev]
   [malli.instrument.cljs]
   [malli.dev.pretty :as pretty]))


(defn a-function 
  {:malli/schema [:=> [:cat :int]
                  :string]}
  [my-int]
  "testing")
  


(defn home-page []
  (h/my-helper [1.2])
  (a-function "not")
  (fn []
    [:div "test"]))


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:dev/after-load refresh []
  (prn "Hot code Remount")
  ; Check all malli function "specs"
  ; (dev/start! {:report (pretty/reporter)})
  (malli.dev.cljs/collect-all!)
  (malli.instrument.cljs/instrument!)
  ; This throws an error as expected
  ; (a-function "45")
  (mount-root))

(defn ^:export init! []
  (mount-root))
