import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("company_sales_data.csv")


df.plot.scatter(x='month_number', y='toothpaste', label='Tooth paste Sales Data')
plt.xticks([1,2,3,4,5,6,7,8,9,10,11,12])
plt.yticks([4500,5000,5500,6000,6500, 7000, 7500, 8000])
plt.xlabel('Month Number')
plt.ylabel('Number of Units Sold')
plt.title('Tooth paste Sales Data')
plt.grid(linestyle='--')
plt.show()