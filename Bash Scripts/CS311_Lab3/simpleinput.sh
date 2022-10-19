make; 
./tester -w traces/simple-input >simple-output;
diff -u simple-output traces/simple-expected-output;
rm simple-output; 
