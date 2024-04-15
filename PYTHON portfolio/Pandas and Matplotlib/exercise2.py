import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("company_sales_data.csv")

df.plot(x='month_number', y='total_units', linewidth=3, label='Profit data of last year', marker='o', linestyle='dashed', color='red')
plt.xticks([1,2,3,4,5,6,7,8,9,10,11,12])
plt.yticks([10000,20000,30000,40000,50000])
plt.xlabel('Month Number')
plt.ylabel('Sold Units Number')
plt.title('Company sales date of last year')
plt.show()