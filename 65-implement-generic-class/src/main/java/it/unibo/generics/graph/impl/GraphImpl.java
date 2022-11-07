package it.unibo.generics.graph.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<E> implements Graph<E>{

    private final Map<E, Set<E>> graph;
        
    public GraphImpl(){
        this.graph=new LinkedHashMap<>();
    }

    @Override
    public void addNode(final E node){
        graph.putIfAbsent(node, new HashSet<>());   
    } 

    @Override
    public void addEdge(final E source, final E target){
        if(graph.containsKey(source) && graph.containsKey(target)){
            graph.get(source).add(target);
        }
    }

    @Override
    public Set<E> nodeSet(){
        return new HashSet<>(graph.keySet());
    }

    @Override
    public Set<E> linkedNodes(final E node){
        return new HashSet<>(this.graph.get(node));
    }
    /*
     * Using BFS by default
     */
    @Override
    public List<E> getPath(final E source, final E target){
        List<E> path= new LinkedList<>();
        Map<E, E> father = new LinkedHashMap<>();
        this.graph.keySet().forEach(t -> father.put(t, null));
        Queue<E> queue= new LinkedList<>();
        Set<E> alreadyVisitedNodes= new HashSet<>();
        queue.add(source);
        while(queue.size()!=0){
            E i=queue.poll();
            for(var k : this.graph.get(i)){
                if(!alreadyVisitedNodes.contains(k) && !queue.contains(k)){
                    father.replace(k, i);
                    queue.add(k);
                }   
            }
            alreadyVisitedNodes.add(i);
        }

        if(father.get(target)==null){
            return Collections.emptyList();
        }

        E current=target;
        while(current!=source){
            path.add(0,current);
            current=father.get(current);
        }
        path.add(0, current);
        return path;
        
    } 
}
