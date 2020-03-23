permutaciones :: [Int] -> [[Int]]
permutaciones []     = [[]]
permutaciones (x:xs) = concat [intercala x ys | ys <- permutaciones xs]

intercala :: Int -> [Int] -> [[Int]]
intercala x []       = [[x]]
intercala x (y:ys)   = (x:y:ys) : [y:zs | zs <- intercala x ys]

subconjuntos :: [a] -> [[a]]
subconjuntos []     = [[]]
subconjuntos (x:xs) = [x:ys | ys <- sub] ++ sub
    where sub = subconjuntos xs

sumasubconjuntos :: [Int] -> Int -> Bool
sumasubconjuntos [] n = n==0
sumasubconjuntos [x] n = x == n
sumasubconjuntos (x:xs) n = sumsub (subconjuntos (x:xs)) n

sumsub :: [[Int]] -> Int -> Bool
sumsub [[]] n = n==0
sumsub (x:xs) n = suma x n || sumsub xs n

suma :: [Int] -> Int -> Bool
suma [] n = n==0
suma [x] n = x==n
suma (x:xs) n = sumita xs (x) == n

sumita :: [Int] -> Int -> Int
sumita [] n = n
sumita (x:xs) n = sumita xs (x+n)

anagrama :: [Int] -> [Int] -> Bool
anagrama [] []         = True
anagrama (x:xs) []     = False
anagrama [] (y:ys)     = False
anagrama (x:xs) (y:ys) = if (length (x:xs) == length (y:ys)) then pertenece (permutaciones (x:xs)) (y:ys) else False

pertenece :: [[Int]] -> [Int] -> Bool
pertenece [] y = False
pertenece (x:xs) (y:ys) = if (iguales x (y:ys)) then True else pertenece xs (y:ys)

iguales :: [Int] -> [Int] -> Bool
iguales [] []           = True
iguales [] (y:xs)       = False
iguales (x:xs) []       = False
iguales (x:xs) (y:ys)   = if (x==y) then iguales xs ys else False

sublista :: Int -> [Int] -> [[Int]]
sublista 0 _ = [[]]
sublista n (x:xs) = sub n (x:xs) ++ sublista (n-1) xs

sub :: Int -> [Int] -> [[Int]]
sub 0 _ = [[]]
sub 1 (x:xs) = [[x]]
sub n (x:xs) = [take n (x:xs)] ++ sub (n-1) (x:xs)

subcadenade :: [Int] -> [Int] -> Bool
subcadenade [] _ = True
subcadenade (x:xs) [] = False
subcadenade (x:xs) ys = probandominisubs (sublista (tamaño 0 (ys)) ys) (x:xs)

tamaño :: Int -> [Int] -> Int
tamaño n [] = n
tamaño n (x:xs) = tamaño (n+1) xs

probandominisubs :: [[Int]] -> [Int] -> Bool
probandominisubs [[]] [] = True
probandominisubs [[]] ys = False
probandominisubs [x] ys = iguales x ys
probandominisubs (x:xs) ys = iguales x ys || probandominisubs xs ys

slowsort :: [Int] -> [Int]
slowsort [] = []
slowsort (x:xs) = correcto (permutaciones (x:xs))

correcto :: [[Int]] -> [Int]
correcto (x:xs) = if (ordenado x) then x else correcto xs

ordenado :: [Int] -> Bool
ordenado [] = True
ordenado [x] = True
ordenado (x:y:xs) = if (x<=y) then ordenado (y:xs) else False

eliminarrepetidos :: [Int] -> [Int]
eliminarrepetidos [] = []
eliminarrepetidos (x:xs) = x:(eliminarrepetidos (eliminar x xs))

eliminar :: Int -> [Int] -> [Int]
eliminar x [] = []
eliminar x (y:ys) = if (x==y) then (eliminar x ys) else y:(eliminar x ys)

subsecuencia :: [Int] -> [Int] -> Bool
subsecuencia (x:xs) [] = False
subsecuencia [] (x:xs) = True
subsecuencia [] [] = True
subsecuencia (x:xs) (y:ys) = if (x==y) then subsecuencia xs ys else subsecuencia (x:xs) ys
