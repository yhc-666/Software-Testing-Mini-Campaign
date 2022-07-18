### Check if both files' extensions are .csv
check if can handle file in wrong format

**boundary value:**

One of the files is not ended with .csv

**middle value:**

Both files are ended with .csv

Both files are not ended with .csv








### Check if any file has records with missing values
comparing records with missing values may causes error

**boundary value:**

Only one record has one missing value

**middle value:**

Several records has several missing values







### Check if any file has two repeat customer ID
repeat customers may cause not able to compare corrctly

**boundary value:**

One of the files has one repeat customer ID, the other one has no repeat customer ID.

**middle value:**

Both files have several(>=1)  repeat customer IDs.







### Check if two files have the same number of records
different number of records can cause nothing to compare leading to the crash of the app
**boundary value:**

One file has one more record than the other one

**middle value:**

One file has more records(>=2) than the other one.
