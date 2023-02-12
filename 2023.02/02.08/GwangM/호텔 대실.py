import heapq
def solution(book_time):
    #사실상 퇴실시간 +9분까지 불가능
    #배열에 쓰고 있는 시간을 넣어둔다. 불가능하면 맨뒤에 추가 
    arr=[]
    max=0    
    book_time.sort()
    for i in book_time:
      i[0]=int(i[0].replace(':',''))
      i[1]=int(i[1].replace(":",''))
      if i[1]%100<51:
        i[1]+=9
      else:
        i[1]+=49
      #temp에 제일 빠른 시간 저장, arr에 퇴실 시간들
      if arr:
        if arr[0]<i[0]:
          heapq.heappop(arr)
        else:
          max+=1
        heapq.heappush(arr,i[1])
      else:
        max+=1
        heapq.heappush(arr,i[1])    
    return max
