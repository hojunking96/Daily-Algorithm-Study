def solution(today, terms, privacies):
    thisYear=int(today[:4])
    thisMonth=int(today[5:7])
    thisDay=int(today[-2:])
    count=1
    answer=[]
    plus=0
    for i in privacies:
      term = i[-1]
      for j in terms:
        if term==j[0]:
          plus=int(j[1:])
          break
      month=int(i[5:7])+plus      
      year=int(i[:4])
      day=int(i[-4:-2])
      if month>12:
        year+=((month-1)//12)
        month%=12
        if month==0:
          month=12
      if year<thisYear or (year==thisYear and month<thisMonth)or(year==thisYear and month==thisMonth and day<=thisDay):
        answer.append(count)
      count+=1

    answer.sort()
    return answer
    
today="2022.05.19"
terms=["A 6","B 100","C 3"]
privacies=["2021.05.02 B"]

print(solution(today,terms,privacies))