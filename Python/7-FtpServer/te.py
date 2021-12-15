ww = 945747
m1 = 130713
m2 = ww - m1

m1c = m1 * 2
m2c = m2 * 2

count = [i for i in range(1, 50)]

for i in count:
    m1cc = i * (m2c / m1c)
    if int(m1cc) == float(m1cc):
        print(i, m2c * i, m1c * i)


