import pandas as pd
import matplotlib.pyplot as plt
df = pd.read_csv("company_sales_data.csv")

axes = plt.gca()

df.plot(x='month_number', y='facecream', linewidth=3, label='Face Cream Sales Data', marker='o', color='blue', ax=axes)
df.plot(x='month_number', y='facewash', linewidth=3, label='Face Wash Sales Data', marker='o', color='orange', ax=axes)
df.plot(x='month_number', y='toothpaste', linewidth=3, label='Toothpaste Sales Data', marker='o', color='green', ax=axes)
df.plot(x='month_number', y='bathingsoap', linewidth=3, label='Bathing Soap Sales Data', marker='o', color='red', ax=axes)
df.plot(x='month_number', y='shampoo', linewidth=3, label='Shampoo Sales Data', marker='o', color='purple', ax=axes)
df.plot(x='month_number', y='moisturizer', linewidth=3, label='Moisturizer Sales Data', marker='o', color='brown', ax=axes)
plt.xticks([1,2,3,4,5,6,7,8,9,10,11,12])
plt.yticks([1000,2000,4000,6000,8000,10000,12000,15000,18000])
plt.xlabel('Month Number')
plt.ylabel('Sales (Units)')
plt.title('Company sales date of last year')
plt.show()