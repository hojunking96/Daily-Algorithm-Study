import heapq
def solution(n, paths, gates, summits):
    #i와 j를 연결하는 w만큼의 weight
    #gates는 시작,도착
    #summits 중 하나를 거쳐야 한다.
  graph=[[]for i in range(n+1)]
  for a,b,w in paths:
    graph[b].append([w,a])
    graph[a].append([w,b])
  for summit in summits:
    graph[summit]=[]
  def dijkstra():
    summitSet=set(summits)
    dp=[float('inf')for i in range(n+1)]
    for gate in gates:
      dp[gate]=0

    hq=[[0,gate] for gate in gates]
    heapq.heapify(hq)
    while(hq):
      hqw,hqv=heapq.heappop(hq)
      if hqv in summitSet or hqw > dp[hqv]:
        continue
      for [gw,gv]in graph[hqv]:
        m=max(gw,dp[hqv])
        if(dp[gv]>m):
          dp[gv]=m
          heapq.heappush(hq,[m,gv])
    return dp
  dp=dijkstra()
  summits.sort(key=lambda x:(dp[x],x))
  return [summits[0],dp[summits[0]]]