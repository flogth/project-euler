(ns project-euler.core
  (:gen-class)
  (:require [clojure.string :as str]))

;; Utilities
(defn divides [x n]
  (zero? (mod n x)))

(def square #(* % %))

;; Problem 1
(defn problem1 []
  (reduce + (filter (fn [x] (or (= 0 (mod x 5))
                             (= 0 (mod x 3))))
              (range 1000))))

;; Problem 2
(defn fib
  ([] (fib 1 1))
  ([a b] (lazy-seq
           (cons a (fib b
                     (+ a b))))))
(defn problem2 []
  (->> (take-while #(< % 4000000)
         (fib))
    (filter even?)
    (reduce +)))

;; Problem 3
(defn add-to-multiple-set [coll n]
  (if (empty? coll)
    [n]
    (conj (remove #(divides n %) coll) n)))

(defn get-dividers [n]
  (loop [res []
         cur (int (Math/sqrt n))]
    (if (>= cur 2)
      (if (divides cur n)
        (recur (add-to-multiple-set res cur) (dec cur))
        (recur res (dec cur)))
      res)))

(defn problem3 []
  (apply max (get-dividers 600851475143)))

;; Problem 4
(defn palindrome? [n]
  (= (str n)
    (str/reverse (str n))))

(defn problem4 []
  (apply max (->>
               (for [x (range 100 1000)
                     y (range 100 1000)]
                 (* x y))
               (filter palindrome?))))

;; Problem 5
(defn problem5 []
  (* 16 9 5 7 11 13 17 19))

;;Problem 6
(defn problem6 []
  (- (square (reduce + (range 101)))
   (reduce + (map square
               (range 101)))))
