module Common where


isPrime :: Integral a => a -> Bool
isPrime n | n <= 3    = n > 1
          | even n    = False
          | otherwise = null $ filter (divides n) [3, 5 .. (intRoot n)]

divides :: Integral a => a -> a -> Bool
divides a b = a `mod` b == 0

intRoot :: Integral a => a -> a
intRoot = floor . sqrt . fromIntegral
