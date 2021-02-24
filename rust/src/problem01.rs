pub fn solve() {
    let r: u32 = (1..1000).filter(pred).sum();
    println!("{}", r);
}

fn pred(n: &u32) -> bool {
    return n % 3 == 0 || n % 5 == 0;
}
