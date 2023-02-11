def solve(li):
  if len(li)==3:
    return li[1]=='1' or li.count('1')==0
  else:
    le=len(li)
    return li.count('1')==0 or (li[le//2]=='1' and solve(li[:le//2]) and solve(li[le//2+1:]))
def solution(numbers):
    answer=[]
    for i in numbers:
     if i<=3:
      answer.append(1)
     else:
      bi=bin(i)[2:]
      le=len(bi)
      sum=1
      temp=2
      while(sum<le):  
        sum+=temp
        temp*=2
      li='0'*(sum-le)+bi
      if solve(li):
        answer.append(1)
      else:
        answer.append(0)
    
    return answer
#2진수로 변환한 0,1의 개수가 1+2+..., 가운데는 1