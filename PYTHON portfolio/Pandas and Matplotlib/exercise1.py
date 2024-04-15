import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("company_sales_data.csv")


df.plot(x='month_number', y='total_profit')
plt.xticks([1,2,3,4,5,6,7,8,9,10,11,12])
plt.yticks([100000,200000,300000,400000,500000])
plt.xlabel('Month Number')
plt.ylabel('Total Profit')
plt.title('Company profit per month')
plt.show()
