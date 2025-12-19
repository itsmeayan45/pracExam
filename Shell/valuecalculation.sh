read -p "Enter the units that can be used for: " units
if [[ $units -le 200 ]]; then
    bill=$(($units * 50))
elif [[ $units -le 400 ]]; then
    bill=$((($units - 200) * 65 / 100 + 100))
elif [[ $units -le 600 ]]; then
    bill=$((($units - 400) * 80 / 100 + 200))
else
    bill=$((($units - 600) * 125 / 100 + 425))
fi

echo "total bill paid by the customer is $bill"