def solution(today, terms, privacies):
    answer = []

    today_y, today_m, today_d = today.split('.')
    today = int(today_y)*12*28 + int(today_m)*28 + int(today_d)

    terms_dic = {term.split(' ')[0] : int(term.split(' ')[1])*28 for term in terms}


    for idx, p in enumerate(privacies):
        date, term = p.split(' ')
        y, m, d = date.split('.')

        check_day = int(y)*12*28 + int(m)*28 + int(d)

        if check_day+terms_dic[term] <= today:
            answer.append(idx+1)


    return answer
