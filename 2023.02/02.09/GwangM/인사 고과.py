def solution(scores):
    answer = 0
    temp=scores[0]
    scores.sort(reverse=True)
    temp1=-1
    temp2=-1
    le=len(scores)
    i=0
    while i<le:
      if scores[i][0]!=temp1 and scores[i][1]>temp2:
        temp1=scores[i][0]
        temp2=scores[i][1]
        j=i+1
        while j<le:
          if temp1>scores[j][0] and temp2>scores[j][1]:
            scores.pop(j)
            le-=1
          else:
            j+=1
      i+=1
    if temp in scores:
      scores=list(map(sum,scores))
      scores.sort(reverse=True)
      answer=scores.index(sum(temp))
      return answer+1
    else:
      return -1


