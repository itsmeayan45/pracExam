input_file=$1
output_file="weather.txt"
while read day temp
do
    if [[ $temp<15 ]];then
        weather="Very Cold"
    elif [[ $temp>=15 && $temp<25 ]];then
        weather="Cold"
    elif [[ $temp>=25 && $temp<35 ]];then
        weather="Hot"
    else
        weather="Very Hot"
    fi
    echo "$day : $temp ---> $weather ">>$output_file
done < $input_file
