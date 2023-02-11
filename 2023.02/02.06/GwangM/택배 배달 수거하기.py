def solution(cap, n, deliveries, pickups):
    p1=0
    p2=0
    answer=0
    for i in range(n-1,-1,-1):
        while p1 < deliveries[i] or p2 < pickups[i]:
          p1+=cap
          p2+=cap
          answer+=(i+1)*2
        p1-=deliveries[i]
        p2-=pickups[i]
          
    return answer

# cap=4;n=5;deliveries=[1,0,3,1,2]
# pickups=[0,3,0,4,0];result=16

# print(solution(cap,n,deliveries,pickups))