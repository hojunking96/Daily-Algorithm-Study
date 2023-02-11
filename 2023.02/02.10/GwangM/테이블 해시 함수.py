def solution(data, col, row_begin, row_end):
    data.sort(key=lambda x:(x[col-1],-x[0]))
    total=0
    answer=0
    row_begin-=1
    row_end-=1
    for i in range(row_begin,row_end+1):
      for j in data[i]:
        total+=(j%(i+1))
      if i==row_begin:
        answer=total
      else:
        answer^=total
      total=0
    
    return answer
