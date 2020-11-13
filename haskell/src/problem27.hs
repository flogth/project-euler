module Problem27 where

import           Common                         ( isPrime )
import           Data.List                      ( maximumBy )

pLength :: (Int -> Int) -> Int
pLength f = length $ takeWhile isPrime [ f n | n <- [0 ..] ]

polynomial :: Int -> Int -> (Int -> Int)
polynomial a b = \n -> n * n + a * n + b


solve :: Int
solve = go $ maximumBy
  (\(x, _, _) (y, _, _) -> compare x y)
  [ ((pLength $ polynomial a b), a, b)
  | a <- [-1000 .. 1000]
  , b <- [-1000 .. 1000]
  ]
  where go (_, a, b) = a * b
