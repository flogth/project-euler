(ns project-euler.core-test
  (:require [clojure.test :refer :all]
            [project-euler.core :refer :all]))

(deftest test-problem1
  (testing "p1"
    (is (= 233168 (problem1)))))

(deftest test-problem2
  (testing "p2"
    (is (= 4613732 (problem2)))))

(deftest test-problem3
  (testing "p3"
    (is (= 6857 (problem3)))))
