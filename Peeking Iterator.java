class PeekingIterator implements Iterator<Integer> {
  public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    buffer = iterator.hasNext() ? iterator.next() : null;
  }
  public Integer peek() {
    return buffer;
  }
  public Integer next() {
    Integer next = buffer;
    buffer = iterator.hasNext() ? iterator.next() : null;
    return next;
  }
  public boolean hasNext() {
    return buffer != null;
  }
  private Iterator<Integer> iterator;
  private Integer buffer;
}
