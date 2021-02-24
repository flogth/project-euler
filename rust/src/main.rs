use std::env;
mod problem01;
mod problem02;
mod problem03;

fn main() {
    let args: Vec<String> = env::args().collect();
    let problem = &args[1];
    match problem.as_str() {
        "01" => problem01::solve(),
        "02" => problem02::solve(),
        "03" => problem03::solve(),
        _ => println!("problem {} is not implemented", problem),
    }
}
