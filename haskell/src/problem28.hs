module Problem28 where

corners :: Int -> Int -> [Int]
corners i s = (+ s) . (* i) <$> [1 .. 4]

spiral :: [Int]
spiral = concat $ zipWith corners [2, 4 .. 1000] [ i * i | i <- [1, 3 ..] ]

solve :: Int
solve = sum spiral + 1
