(ns project-euler.04problem
  (:require [clojure.string :as str]))

(defn palindrome? [n]
  (= (str n)
    (str/reverse (str n))))

(apply max (->>
             (for [x (range 100 1000)
                   y (range 100 1000)]
               (* x y))
             (filter palindrome?)))
