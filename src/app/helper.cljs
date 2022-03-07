(ns app.helper)

(def MyType [:vector float?])

(defn my-helper
  {:malli/schema [:=> [:cat MyType]
                  MyType]}
  [arg]
  arg)
