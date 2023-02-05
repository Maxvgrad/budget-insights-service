#!/usr/bin/python3

import requests
import os
import sys

if len(sys.argv) != 2:
    print("Usage: python script.py folder_path")
    sys.exit(1)

folder_path = sys.argv[1]
url = 'http://localhost:8080/budget-insights/statements'
headers = {'Content-Type': 'multipart/form-data'}

for filename in os.listdir(folder_path):
    file_path = os.path.join(folder_path, filename)
    with open(file_path, 'rb') as file:
        files = {'file': (filename, file)}
        response = requests.post(url, files=files)
        if response.status_code == 200:
            print(f'Successfully uploaded {filename}')
        else:
            print(f'Failed to upload {filename}')