import streamlit as st
import pandas as pd
import numpy as np
from sklearn.preprocessing import LabelEncoder

@st.cache_data(persist=True)
def load_data(data_path):
    try:
        data = pd.read_csv(data_path)
        label = LabelEncoder()
        for col in data:
            data[col] = label.fit_transform(data[col])
        return data
    except:
        return None

def main():
    st.subheader("Mushrooms data")
    data = load_data("./data/mushrooms.csv")
    st.write(data.type)
    if data is not None:
        st.write(data)

if __name__=="__main__":
    main()
