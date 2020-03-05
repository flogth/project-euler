(ns project-euler.03problem)

(defn divides [x n]
  (= 0 (mod n x)))

(def n 600851475143)

(defn add-to-multiple-set [coll n]
  (if (empty? coll)
    [n]
    (conj (remove #(divides n %) coll) n)))

(def get-dividers

  (loop [res []
         cur (int (Math/sqrt n))]
    (if (>= cur 2)
      (if (divides cur n)
        (recur res (dec cur))
        (recur res (dec cur)))
      res)))

(get-dividers)
