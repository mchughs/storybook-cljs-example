(ns components.button)

(defn component
  "My button doc string."
  [opts & [text]]
  [:button opts
   (or text "Hello World")])
