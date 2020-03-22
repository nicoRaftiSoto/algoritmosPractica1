permutaciones :: [a] -> [[a]]
permutaciones []     = [[]]
permutaciones (x:xs) = concat [intercala x ys | ys <- permutaciones xs]

intercala :: a -> [a] -> [[a]]
intercala x []       = [[x]]
intercala x (y:ys)   = (x:y:ys) : [y:zs | zs <- intercala x ys]

subconjuntos :: [a] -> [[a]]
subconjuntos []     = [[]]
subconjuntos (x:xs) = [x:ys | ys <- sub] ++ sub
    where sub = subconjuntos xs

sublista :: Int -> [a] -> [[a]]
sublista 0 _ = [[]]
sublista n (x:xs) = sub n (x:xs) ++ sublista (n-1) xs

sub :: Int -> [a] -> [[a]]
sub 0 _ = [[]]
sub 1 (x:xs) = [[x]]
sub n (x:xs) = [take n (x:xs)] ++ sub (n-1) (x:xs)
