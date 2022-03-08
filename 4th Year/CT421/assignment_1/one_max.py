#!/usr/bin/env python

import common
from numpy.random import randint
from dataclasses import dataclass


@dataclass
class Config(common.Config):
    max_value: int

    def __init__(self):
        super().__init__()
        self.max_value = (1 << self.length) - 1

    def main(self):
        population = []

        # Generate a population of individuals
        for i in range(0, self.population_size):
            population.append(randint(0, self.max_value + 1))

        self.genetic_algorithm(population, fitness, self.make_mutation)
        self.plot('One Max')


def fitness(individual):
    # Count the number of 1's
    return individual.bit_count()


if __name__ == '__main__':
    c = Config()
    c.main()
