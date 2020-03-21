permutaciones :: [a] -> [[a]]
permutaciones []     = [[]]
permutaciones (x:xs) = concat [intercala x ys | ys <- permutaciones xs]

intercala :: a -> [a] -> [[a]]
intercala x [] = [[x]]
intercala x (y:ys) = (x:y:ys) : [y:zs | zs <- intercala x ys]
