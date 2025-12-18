

# 1. Check if the user provided an argument (n)
if [ $# -eq 0 ]; then
    echo "Usage: $0 <number_of_terms>"
    exit 1
fi

n=$1
output_file="fibonacci_series.txt"
a=0
b=1

# 3. Create/Clear the output file and start writing
# We use ">" to overwrite/create the file
echo "Generating the first $n Fibonacci numbers..."
echo -n "" > "$output_file" 


for (( i=0; i<n; i++ )); do

    echo -n "$a " >> "$output_file"
    
    
    fn=$((a + b))
    
    
    a=$b
    b=$fn
done

echo "" >> "$output_file"

echo "Done! Result stored in '$output_file'."