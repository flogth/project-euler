(ns project-euler.02problem)

(defn fib
  ([] (fib 1 1))
  ([a b] (lazy-seq
           (cons a (fib b
                     (+ a b))))))

(reduce +
  (filter even?
    (take-while #(< % 4000000)
      (fib))))
