from itertools import count
import random
import os
import re
import pandas as pd
from fuzzing_generator import Fuzzing_generator
generator = Fuzzing_generator()
for i in range(20):
    file_name = "test" + str(i+1) +'.csv'
    if random.random() < 0.5:
        ordered = True
    else:
        ordered = False
    generator.generate_test_csv(fuzz_rate=0.6, min_row_num=30, max_row_num=100, file_name=file_name)