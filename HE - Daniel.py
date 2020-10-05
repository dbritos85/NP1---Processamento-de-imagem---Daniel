entrada = []

try:
    entrada = list(map(int, input( "favor inserir separando por ,").split(",")))
except Exception as e:
    print("Favor informar um array com os valores de cada pixel.")
    exit()
    
quantidade = entrada.__len__()

print(entrada)
print(quantidade)

for a in entrada:
    teste = a
    print(teste)
