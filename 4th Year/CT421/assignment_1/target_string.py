#!/usr/bin/env python

import common
from numpy.random import randint
from dataclasses import dataclass


@dataclass
class Config(common.Config):
    max_value: int
    target: int

    def __init__(self):
        super().__init__()
        self.max_value = (1 << self.length) - 1
        self.target = randint(0, self.max_value)

    def main(self):
        population = []

        # Generate a population of individuals
        for i in range(0, self.population_size):
            population.append(randint(0, self.max_value+1))

        self.genetic_algorithm(population, self.fitness, self.make_mutation)
        self.plot('Target String')

    def fitness(self, individual):
        current_score = 0
        for i in range(self.length):
            # run over all the bits in the int, for all bits that are the
            # same as the target, increment the score
            if ((individual >> i) & 1) == ((self.target >> i) & 1):
                current_score += 1
        return current_score


if __name__ == '__main__':
    c = Config()
    c.main()
