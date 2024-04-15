import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("company_sales_data.csv")

facecream = df['facecream'].tolist()
facewash = df['facewash'].tolist()
df[['facecream', 'facewash']].plot.bar()

x = [0,1,2,3,4,5,6,7,8,9,10,11]

plt.xticks(x, [1,2,3,4,5,6,7,8,9,10,11,12])
plt.yticks([0,500,1000,1500,2000,2500,3000,3500])
plt.xlabel('Month Number')
plt.ylabel('Sales units in number')
plt.title('Facewash and facecream sales data')
plt.grid(linestyle='--')
plt.show()