(ns project-euler.03problem)

(defn divides [x n]
  (= 0 (mod n x)))

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

(apply max (get-dividers 600851475143))
