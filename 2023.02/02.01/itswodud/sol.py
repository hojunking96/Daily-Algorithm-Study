import datetime

def add_month_to_datetime(datetime_string: str, add_month: int):
    splited_datetime_string = datetime_string.split('.')
    
    year = int(splited_datetime_string[0])
    month = int(splited_datetime_string[1])
    day = int(splited_datetime_string[2])
    
    add_year = add_month//12
    add_month = add_month%12
    
    if month+add_month == 12:
        new_year = year
    else:
        new_year = year + (month+add_month)//12 if add_month != 0 else year+1 
    new_month = 12 if (month+add_month)%12 == 0 else (month+add_month)%12
    new_day = day

    result_date = datetime.datetime(new_year, new_month, new_day) - datetime.timedelta(days=1)

    if result_date.day > 28:
        result_date = result_date.replace(day=28)
    
    return result_date
    
def solution(today, terms, privacies):
    answer = []
    
    term_dict = {}
    
    today_datetime = datetime.datetime.strptime(today, '%Y.%m.%d')
    
    for term in terms:
        splited_term = term.split(' ')
        term_dict[splited_term[0]] = int(splited_term[1])
    
    for i, privacy in enumerate(privacies):
        splited_privacy = privacy.split(' ')
        if today_datetime > add_month_to_datetime(splited_privacy[0], term_dict[splited_privacy[1]]):
            
            answer.append(i+1) 
        
    
    return answer
