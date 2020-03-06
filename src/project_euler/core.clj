(ns project-euler.core
  (:gen-class)
  (:require [clojure.string :as str]))

;; Utilities
(defn divides [x n]
  (zero? (mod n x)))

(def square #(* % %))

(defn prime? [n]
  (let [root (Math/sqrt n)]
    (cond
      (<= n 1) false
      (= n 2) true
      :else (loop [d 3]
              (if (> d root)
                true
                (if (divides d n)
                  false
                  (recur (+ d 2))))))))

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

;;Problem 7
;; Finds 10001th prime number, 10000 in code because 2 is omitted
(defn problem7 []
  (last (take 10000
          (filter prime?
            (iterate #(+ % 2) 3)))))

;;Problem 8
(defn parse-digits [st]
  (map #(Integer/parseInt %)
    (str/split st #"")))

(defn bigger
  "Take two values and choose the bigger of the two"
  [a b]
  (if (> a b)
    a
    b))

(defn problem8 []
  (let [input "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450"]
    (loop [index 0
           res 0]
      (let [end-index (+ index 13)
            mul (apply * (parse-digits
                           (subs input index end-index)))]
        (if (>= end-index (count input))
          res
          (recur (inc index)
            (bigger mul res)))))))

;;Problem 9
;;TODO Awful performance -> rethink this!
(defn problem9 []
  (->> (filter (fn [x] (= (square (:c x))
                        (+ (square (:a x))
                          (square (:b x)))))
         (filter (fn [x] (= 1000 (reduce + (vals x))))
           (for [a (range 998)
                 b (range (inc a) 998)
                 c (range (inc b) 998)]
             {:a a :b b :c c})))
    first
    vals
    (reduce *)))
